package com.copasso.chaoniu.presenter.contract;

import com.copasso.chaoniu.base.BaseContract;
import com.copasso.chaoniu.model.bean.remote.MyUser;

/**
 * Created by Zhouas666 on 2019-01-08
 * Github: https://github.com/zas023
 */
public interface UserInfoContract extends BaseContract {

    interface View extends BaseView {

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 更新用户信息
         */
        void updateUser(MyUser user);
    }
}
