package io.monkeypatch.monkeyconf.app

import kotlinx.coroutines.*

class DetailsPresenter(
    view: TalkDetailsView,
    private val repo: ConferenceRepository,
    private val uiDispatcher: CoroutineDispatcher
) : BasePresenter<TalkDetailsView>(view) {

    fun getTalk(id: String) {
        launch(uiDispatcher) {
            val talk = repo.getTalk(id)
            view.displayTalk(talk)
        }
    }
}