package com.cocoslime.presentation.paging


import androidx.paging.PagingData
import com.cocoslime.data.model.GithubRepoResponse
import com.cocoslime.presentation.data.service.TestGithubService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PagingViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val dispatcherRule = UnconfinedTestDispatcher()

    private lateinit var viewModel: PagingViewModel

    @Before
    fun setup() {
        viewModel = PagingViewModel(
            githubService = TestGithubService()
        )
    }

    @Test
    fun test_items_contain_one_to_ten() = runTest {
        // Get the Flow of PagingData from the ViewModel under test
        val items: Flow<PagingData<GithubRepoResponse>> = viewModel.repoPagingFlow

        val itemsSnapshot: List<GithubRepoResponse> = items.asSnapshot {
            // Scroll to the 50th item in the list. This will also suspend till
            // the prefetch requirement is met if there's one.
            // It also suspends until all loading is complete.
            scrollTo(index = 50)
        }

        // With the asSnapshot complete, you can now verify that the snapshot
        // has the expected values
        assertEquals(
            expected = (0..50).map(Int::toString),
            actual = itemsSnapshot
        )
    }
}