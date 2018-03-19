package com.zbq.library.aop;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.zbq.annotation.aspect.Permission;
import com.zbq.library.base.BaseApplication;
import com.zbq.library.util.MPermissionUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * 申请系统权限切片，根据注解值申请所需运行权限
 *
 * Created by zhongbingqi on 2018/3/15.
 */
@Aspect
public class SysPermissionAspect {

    @Around("execution(@com.zbq.annotation.aspect.Permission * *(..)) && @annotation(permission)")
    public void aroundJoinPoint(final ProceedingJoinPoint joinPoint,final Permission permission) throws Throwable {
        final AppCompatActivity ac = (AppCompatActivity) BaseApplication.getAppContext().getCurActivity();
        new AlertDialog.Builder(ac)
                .setTitle("提示")
                .setMessage("为了应用可以正常使用，请您点击确认申请权限。")
                .setNegativeButton("取消", null)
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MPermissionUtils.requestPermissionsResult(ac, 1, permission.value()
                                , new MPermissionUtils.OnPermissionListener() {
                                    @Override
                                    public void onPermissionGranted() {
                                        try {
                                            joinPoint.proceed();//获得权限，执行原方法
                                        } catch (Throwable e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onPermissionDenied() {
                                        MPermissionUtils.showTipsDialog(ac);
                                    }
                                });
                    }
                })
                .create()
                .show();
    }
}


