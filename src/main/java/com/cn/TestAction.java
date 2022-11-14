package com.cn;


import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;

import java.util.ArrayList;
import java.util.List;

public class TestAction extends AnAction {
    List<String> resultList = new ArrayList<>();


    @Override
    public void actionPerformed(AnActionEvent event) {

        // Using the event, create and show a dialog
        Project currentProject = event.getProject();
        StringBuilder message =
                new StringBuilder(event.getPresentation().getText() + " Selected!");
        // If an element is selected in the editor, add info about it.
        Navigatable selectedElement = event.getData(CommonDataKeys.NAVIGATABLE);
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement);
        }
        String title = event.getPresentation().getDescription();

        resultList.add("1");
        System.out.println(resultList);
        Messages.showMessageDialog(
                currentProject,
                resultList.toString(),
                title,
                Messages.getInformationIcon());


//        ActionManager actionManager = e.getActionManager();
//        AnAction testFile = actionManager.getAction("TestFile");
//
//        NotificationGroup notificationGroup = new NotificationGroup("testid", NotificationDisplayType.BALLOON, false);
//        /**
//         * content :  通知内容
//         * type  ：通知的类型，warning,info,error
//         */
//        Notification notification = notificationGroup.createNotification("测试通知", MessageType.INFO);
//        Notifications.Bus.notify(notification);
//
//        Project project = e.getData(PlatformDataKeys.PROJECT);
//        Messages.showMessageDialog(project, "helloword", "test2", Messages.getInformationIcon());
    }

}
