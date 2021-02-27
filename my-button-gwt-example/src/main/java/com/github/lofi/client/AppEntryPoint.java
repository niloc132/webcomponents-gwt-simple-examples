package com.github.lofi.client;

import com.github.lofi.client.components.Es5CustomElementHelper;
import com.github.lofi.client.components.MyButton;
//import com.google.gwt.core.client.EntryPoint;

import elemental2.dom.DomGlobal;

public class AppEntryPoint /*implements EntryPoint*/ {

//	@Override
	public void onModuleLoad() {
		DomGlobal.customElements.define("my-button", MyButton.class);
//		Es5CustomElementHelper.registerEs5("my-button", MyButton.class, MyButton::init);
	}
}
