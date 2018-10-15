package com.yveschiong.yelpreviews.common;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.yveschiong.yelpreviews.R;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends Fragment {
    protected final CompositeDisposable disposables = new CompositeDisposable();

    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }

    protected void showGenericErrorToast() {
        Toast.makeText(getContext(), R.string.generic_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        disposables.clear();
    }
}
