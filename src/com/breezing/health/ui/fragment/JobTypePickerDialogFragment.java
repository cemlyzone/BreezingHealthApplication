package com.breezing.health.ui.fragment;

import net.simonvt.numberpicker.NumberPicker;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.breezing.health.R;

public class JobTypePickerDialogFragment extends BaseDialogFragment implements OnClickListener {

    private View mFragmentView;
    private NumberPicker mType;
    private TextView mTitle;
    private Button mCancel;
    private Button mConfirm;
    private DialogFragmentInterface.OnClickListener mPositiveClickListener;
    private DialogFragmentInterface.OnClickListener mNegativeClickListener;
    private String mTitleString;
    
    public static JobTypePickerDialogFragment newInstance() {
        JobTypePickerDialogFragment fragment = new JobTypePickerDialogFragment();
        return fragment;
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.AppTheme_NoTitleBar);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        
        mFragmentView = inflater.inflate(R.layout.fragment_dialog_job_type_picker, null);
        mType = (NumberPicker) mFragmentView.findViewById(R.id.type);
        mTitle = (TextView) mFragmentView.findViewById(R.id.title);
        mCancel = (Button) mFragmentView.findViewById(R.id.cancel);
        mConfirm = (Button) mFragmentView.findViewById(R.id.confirm);
        
        final String[] types = getActivity().getResources().getStringArray(R.array.jobTypes);
        mType.setDisplayedValues(types);
        mType.setMaxValue(types.length - 1);
        mType.setMinValue(0);
        mType.setFocusable(true);
        mType.setFocusableInTouchMode(true);
        
        if (mTitleString != null) {
            mTitle.setText(mTitleString);
        }
        
        mCancel.setOnClickListener(this);
        mConfirm.setOnClickListener(this);
        
        getDialog().getWindow().setBackgroundDrawable(new
                ColorDrawable(Color.TRANSPARENT));
        
        return mFragmentView;
    }
    
    public void setTitle(String titleString) {
        mTitleString = titleString;
    }
    
    public void setPositiveClickListener(DialogFragmentInterface.OnClickListener listener) {
        mPositiveClickListener = listener;
    }
    
    public void setNegativeClickListener(DialogFragmentInterface.OnClickListener listener) {
        mNegativeClickListener = listener;
    }
    
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v == mConfirm) {
            if (mPositiveClickListener != null) {
                mPositiveClickListener.onClick(this);
            }
            dismiss();
            return ;
        } else if (v == mCancel) {
            if (mNegativeClickListener != null) {
                mNegativeClickListener.onClick(this);
            }
            dismiss();
            return ;
        }
    }
    
}
