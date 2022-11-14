package com.yp.tempplugin.config;


import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.EditorEventListener;
import com.yp.tempplugin.util.PlayMusic;
import com.yp.tempplugin.util.StaticString;
import org.jetbrains.annotations.NotNull;

/**
 * 配置编辑器在每个编辑器都生效
 *
 * @author mr.ahai
 */
@SuppressWarnings("All")
public class EditorListenerConfig implements EditorEventListener {

    private ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();

    /**
     * 在文档被修改之前播放音乐
     *
     * @param event the event containing the information about the change.
     */
    @Override
    public void beforeDocumentChange(@NotNull DocumentEvent event) {
        if (StaticString.IS_START_PLAY_MUSIC){
            threadPoolConfig.runSomething(() -> PlayMusic.playMusic(StaticString.LOCAL_MUSIC_PATH));
        }
        // 打包插件之前采用相对路径，才可以访问静态资源
        // threadPoolConfig.runSomething(() -> Play
        // Music.playMusic(StaticString.ONLINE_MUSIC_PATH));
    }
}
