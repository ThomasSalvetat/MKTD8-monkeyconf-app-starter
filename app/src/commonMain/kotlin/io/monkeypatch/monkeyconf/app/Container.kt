package io.monkeypatch.monkeyconf.app

import io.monkeypatch.monkeyconf.app.utils.CommonDispatcher
import io.monkeypatch.monkeyconf.app.utils.ThreadLocal
import kotlinx.coroutines.CoroutineDispatcher

@ThreadLocal
object Container {
    private val uiDispatcher: CoroutineDispatcher = CommonDispatcher.ui

    val conferenceRepository = ConferenceRepositoryImpl("https://monkeyconf.herokuapp.com/")

    fun getConferencePresenter(view: TalkListView) = ConferencePresenter(view, conferenceRepository, uiDispatcher)

    fun getDetailsPresenter(view: TalkDetailsView) = DetailsPresenter(view, conferenceRepository, uiDispatcher)
}