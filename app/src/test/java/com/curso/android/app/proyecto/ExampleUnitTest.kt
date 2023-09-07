package com.curso.android.app.proyecto



import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.proyecto.vista.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before//inicializo viewModel
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.modelo.value?.resulta
        assertEquals("estan vacias", value)
    }

    @Test
    fun mainViewModel_comparar() = runTest {

        launch {
            viewModel.comparar("a", "b")
        }
        advanceUntilIdle()
        val value = viewModel.modelo.value?.resulta
        assertEquals(/* expected = */ "Son distintas", /* actual = */ value)
    }
}