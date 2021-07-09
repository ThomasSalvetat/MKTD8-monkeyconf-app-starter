package io.monkeypatch.monkeyconf.app

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class ConferencePresenter(
    view: TalkListView,
    private val repo: ConferenceRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter<TalkListView>(view) {

    private var talks = emptyList<Talk>()

    override fun onCreate() {
        super.onCreate()
        loadConferences()
    }

    private fun loadConferences() {
        launch(uiDispatcher) {
            try {
                talks = repo.getConference()
                view.displayConferences(talks)
            } catch (e: Exception) {
                view.displayError(e)
            } finally {
                view.showLoading(false)
            }
        }
    }
}