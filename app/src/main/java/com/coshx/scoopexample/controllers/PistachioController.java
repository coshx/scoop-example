package com.coshx.scoopexample.controllers;

import com.coshx.scoopexample.R;
import com.lyft.scoop.ViewController;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * PistachioController
 * <p/>
 */
public class PistachioController extends ViewController {
    @Override
    protected int layoutId() {
        return R.layout.pistachio;
    }

    @Override
    public void onAttach() {
        super.onAttach();

        ButterKnife.bind(this, getView());
    }

    @OnClick(R.id.pistachio_button)
    public void onPistachioButtonClick() {
        // TODO later
    }
}
