package com.devaeon.retrofit.ui.dashboard

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.devaeon.retrofit.databinding.FragmentDashboardBinding
import kotlinx.coroutines.launch

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val dashboardViewModel by lazy { ViewModelProvider(this)[DashboardViewModel::class.java] }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textDashboard.movementMethod = ScrollingMovementMethod()

        viewLifecycleOwner.lifecycleScope.launch {
            dashboardViewModel.projectsState.collect { state ->
                when (state) {
                    is UiState.Loading -> {
                        binding.textDashboard.text = "Loading..."
                    }

                    is UiState.Success -> {
                        val projects = state.data

                        val formattedData = projects.entries.joinToString("\n\n") { (key, project) ->
                            """
                            🔹 **Project Name**: $key
                            🆔 ID: ${project.id}
                            🔄 State: ${project.state}
                            🔗 Links: ${project.webLinks.joinToString { it.url }}
                            """.trimIndent()
                        }
                        binding.textDashboard.text = formattedData // Display actual project data
                    }

                    is UiState.Error -> {
                        binding.textDashboard.text = "Error: ${state.message}"
                    }
                }
            }
        }

        with(dashboardViewModel)
        {
            fetchProjectsResponse()
//            fetchProjectsRaw()
//            fetchProjectsCall()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}