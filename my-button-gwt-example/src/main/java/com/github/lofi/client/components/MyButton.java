package com.github.lofi.client.components;

import elemental2.core.Function;
import elemental2.core.JsArray;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.ShadowRoot;
import jsinterop.annotations.*;
import jsinterop.base.Js;
import jsinterop.base.JsConstructorFn;
import jsinterop.base.JsPropertyMap;

import java.util.ArrayList;
import java.util.function.Consumer;

import static elemental2.dom.DomGlobal.customElements;
import static jsinterop.base.Js.asConstructorFn;

// this means we can have at most one constructor defined, at least as far as JS is concerned,
// and that the ctor will be the main way to create intstances
@JsType
public class MyButton extends HTMLElement {

    private static final String LABEL = "label";

    private String field1;
    private String field2 = "hasValueFromInitializer";// this _may_ be lost when used as an es5 type, don't risk it

    private int field3;
    private int field4 = 1;// this _may_ be lost when used as an es5 type, don't risk it

    private ArrayList<String> field5;
    // this will be lost when used as an es5 type
    private ArrayList<String> field6 = new ArrayList<String>();

    public MyButton() {
//        HTMLElement.AttachShadowOptionsType options = new AttachShadowOptionsType() {
//
//            private String mode;
//
//            @Override
//            public void setMode(String mode) {
//                this.mode = mode;
//            }
//
//            @Override
//            public String getMode() {
//                return this.mode;
//            }
//        };
//
//        options.setMode("open");
//        ShadowRoot shadowRoot = attachShadow(options);
//        shadowRoot.innerHTML = "<div class=\"container\"><button>My Button</button></div>";

        // these will all be lost when used as an es5 type
        field1 = "hasValueFromCtor";
        field3 = field1.length();
        field5 = new ArrayList<String>();
    }

    public void init() {

        field1 = "hasValueFromCtor";
        field3 = field1.length();
        field5 = new ArrayList<String>();
    }

    public void connectedCallback() {
        HTMLElement.AttachShadowOptionsType options = new AttachShadowOptionsType() {

            private String mode;

            @Override
            public void setMode(String mode) {
                this.mode = mode;
            }

            @Override
            public String getMode() {
                return this.mode;
            }
        };

        options.setMode("open");
        ShadowRoot shadowRoot = attachShadow(options);
        shadowRoot.innerHTML = "<div class=\"container\"><button>My Button</button></div>";
        shadowRoot.firstElementChild.setAttribute("title", toString());
    }

    @JsProperty(name = LABEL)
    public String getRef() {
        String value = this.getAttribute(LABEL);
        return value == null ? toString() : value;
    }

    @JsProperty(name = LABEL)
    public void setRef(String value) {
        this.setAttribute(LABEL, value);
    }

    @JsProperty
    public String[] getObservedAttributes() {
        return new String[] { LABEL };
    }

    @Override
    public Object attributeChangedCallback(String attributeName, String oldValue, String newValue, String namespace) {
        return super.attributeChangedCallback(attributeName, oldValue, newValue, namespace);
    }

    @Override
    public String toString() {
        return field1 + field2 + field3 + field4 + field5 + field6;
    }
}
