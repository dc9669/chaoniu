package com.copasso.chaoniu.presenter.contract;

import com.copasso.chaoniu.base.BaseContract;
import com.copasso.chaoniu.model.bean.local.BSort;
import com.copasso.chaoniu.model.bean.local.NoteBean;

import java.util.List;

/**
 * Created by Zhouas666 on 2019-01-08
 * Github: https://github.com/zas023
 */
public interface BillNoteContract extends BaseContract {

    interface View extends BaseView {

        void loadDataSuccess(NoteBean bean);

    }

    interface Presenter extends BasePresenter<View>{
        /**
         * 获取信息
         */
        void getBillNote();

        void updateBBsorts(List<BSort> items);

        void addBSort(BSort bSort);
        void deleteBSortByID(Long id);
    }
}
