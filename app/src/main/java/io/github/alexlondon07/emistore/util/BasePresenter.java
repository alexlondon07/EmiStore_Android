package io.github.alexlondon07.emistore.util;

import io.github.alexlondon07.emistore.helper.IValidateInternet;

/**
 * Created by alexlondon07 on 10/22/17.
 */

public class BasePresenter<T extends IBaseView> {
    private T view;
    private IValidateInternet validateInternet;

    public BasePresenter() {
    }

    public void inject(T view, IValidateInternet validateInternet){
        this.view = view;
        this.validateInternet = validateInternet;
    }

    public T getView() {
        return view;
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }

}
