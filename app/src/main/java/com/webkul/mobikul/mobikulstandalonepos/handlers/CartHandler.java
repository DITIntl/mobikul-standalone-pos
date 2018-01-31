package com.webkul.mobikul.mobikulstandalonepos.handlers;

import android.content.Context;
import android.content.Intent;

import com.webkul.mobikul.mobikulstandalonepos.activity.Checkout;
import com.webkul.mobikul.mobikulstandalonepos.activity.CartActivity;
import com.webkul.mobikul.mobikulstandalonepos.activity.CustomerActivity;
import com.webkul.mobikul.mobikulstandalonepos.helper.AppSharedPref;
import com.webkul.mobikul.mobikulstandalonepos.model.CartModel;

/**
 * Created by aman.gupta on 18/1/18. @Webkul Software Private limited
 */

public class CartHandler {

    private Context context;

    public CartHandler(Context context) {
        this.context = context;
    }

    public void holdOrder(CartModel cartData) {

    }

    public void deleteAll() {
        AppSharedPref.deleteCartData(context);
        ((CartActivity) context).finish();
    }

    public void proceedToCheckout(CartModel cartData) {
        Intent i = new Intent(context, Checkout.class);
        i.putExtra("cartData", cartData);
        context.startActivity(i);
    }

    public void selectCustomer() {
        Intent i = new Intent(context, CustomerActivity.class);
        i.putExtra("choose_customer", "");
        ((CartActivity) context).startActivityForResult(i, 2);
    }
}
