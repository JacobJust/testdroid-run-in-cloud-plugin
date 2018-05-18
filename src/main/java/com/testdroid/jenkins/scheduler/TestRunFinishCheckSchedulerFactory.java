package com.testdroid.jenkins.scheduler;

import com.testdroid.jenkins.model.TestRunStateCheckMethod;

public class TestRunFinishCheckSchedulerFactory {

    public static TestRunFinishCheckScheduler createTestRunFinishScheduler(TestRunStateCheckMethod method) {
        TestRunFinishCheckScheduler result;
        switch (method) {
            case API_CALL:
                result = new APIDrivenTestFinishCheckScheduler();
                break;
            case HOOK_URL:
            default:
                result = new HookUrlDrivenTestFinishCheckScheduler();
                break;
        }
        return result;
    }

}
