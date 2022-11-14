package com.yp.sql;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowManager;
import org.jetbrains.annotations.NotNull;

/**
 * @ClassName: JpaSqlLogAction
 * @Author: zhangyingqi
 * @Description: sql restore action
 * @Date: Created in 17:24 2020/7/9
 * @Modified By:
 */
public class JpaSqlLogAction extends AnAction {

    @Override
    public void update(AnActionEvent e) {
        // Using the event, evaluate the context, and enable or disable the action.
        Project project = e.getProject();
        e.getPresentation().setEnabledAndVisible(project != null);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {

        ToolWindowManager.getInstance(event.getProject()).getToolWindow("JpaSqlLog").show();
        //ToolWindow toolWindow = ToolWindowManager.getInstance(event.getProject()).getToolWindow("JpaSqlLog");
        //new JpaToolWindow(event.getProject(),toolWindow);
    }

}
