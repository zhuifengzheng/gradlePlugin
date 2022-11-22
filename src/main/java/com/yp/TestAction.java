package com.yp;


import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;

import java.util.ArrayList;
import java.util.List;

public class TestAction extends AnAction {
    List<String> resultList = new ArrayList<>();

    private static final Logger logger = Logger.getInstance(TestAction.class);

    @Override
    public void actionPerformed(AnActionEvent event) {

        // 获取当前工程
        Project currentProject = event.getProject();
        StringBuilder message =
                new StringBuilder(event.getPresentation().getText() + " Selected!");
        // 获取当前选中对象
        Navigatable selectedElement = event.getData(CommonDataKeys.NAVIGATABLE);
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement);
        }
        String title = event.getPresentation().getDescription();

        // 显示弹框
        Messages.showMessageDialog(
                currentProject,
                resultList.toString(),
                title,
                Messages.getInformationIcon());

        // ------------------------------------------------------------------------------------

        ActionManager actionManager = event.getActionManager();
        AnAction testFile = actionManager.getAction("TestFile");


        NotificationGroup notificationGroup = new NotificationGroup("testid", NotificationDisplayType.BALLOON, false);
        /**
         * content :  通知内容
         * type  ：通知的类型，warning,info,error
         */
        Notification notification = notificationGroup.createNotification("测试通知", MessageType.INFO);
        Notifications.Bus.notify(notification);

        // 获取当前工程
        Project project = event.getData(PlatformDataKeys.PROJECT);
        Messages.showMessageDialog(project, "helloword", "test2", Messages.getInformationIcon());

        // ------------------------------------------------------------------------------------

        NotificationGroupManager.getInstance().getNotificationGroup("test").createNotification("测试通知", MessageType.INFO);
    }

}
