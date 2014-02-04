package com.moceanmobile.mast.samples;

import java.util.Map;

import android.os.Bundle;
import android.view.View;

import com.moceanmobile.mast.MASTAdView;
import com.moceanmobile.mast.MASTAdViewDelegate;

public class ErrorHide extends RefreshActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_error_hide);
		
		MASTAdView adView = (MASTAdView) findViewById(R.id.adView);
		
		adView.setRequestListener(new MASTAdViewDelegate.RequestListener()
		{
			@Override
			public void onFailedToReceiveAd(final MASTAdView adView, Exception ex)
			{
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						adView.setVisibility(View.GONE);
					}
				});
			}

			@Override
			public void onReceivedAd(final MASTAdView adView)
			{
				runOnUiThread(new Runnable()
				{
					@Override
					public void run()
					{
						adView.setVisibility(View.VISIBLE);
					}
				});
			}

			@Override
			public void onReceivedThirdPartyRequest(MASTAdView adView,
					Map<String, String> properties,
					Map<String, String> parameters)
			{
				
			}
		});
	}
}
