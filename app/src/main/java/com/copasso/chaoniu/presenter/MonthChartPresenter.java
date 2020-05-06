package com.copasso.chaoniu.presenter;

import com.copasso.chaoniu.base.BaseObserver;
import com.copasso.chaoniu.base.RxPresenter;
import com.copasso.chaoniu.model.bean.local.BBill;
import com.copasso.chaoniu.model.repository.LocalRepository;
import com.copasso.chaoniu.presenter.contract.MonthChartContract;
import com.copasso.chaoniu.utils.BillUtils;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Zhouas666 on 2019-01-08
 * Github: https://github.com/zas023
 */
public class MonthChartPresenter extends RxPresenter<MonthChartContract.View> implements MonthChartContract.Presenter{

    private String TAG="MonthChartPresenter";

    @Override
    public void getMonthChart(String id, String year, String month) {
        LocalRepository.getInstance().getBBillByUserIdWithYM(id, year, month)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<List<BBill>>() {
                    @Override
                    protected void onSuccees(List<BBill> bBills) throws Exception {
                        mView.loadDataSuccess(BillUtils.packageChartList(bBills));
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        mView.onFailure(e);
                    }
                });
    }
}
