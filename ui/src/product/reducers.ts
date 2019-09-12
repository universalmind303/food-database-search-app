import { getDefaultProducts, Products } from "./model";
import {actions} from '../actions';

const resetProducts = (state: any) => Products.update(state, {
    $set: getDefaultProducts()
});

const setProducts = (state: any, action: any) => Products.update(state, {
    $set: action.products
});

const actionTypes = {
    [actions.RESET_PRODUCTS]: resetProducts,
    [actions.SET_PRODUCTS]: setProducts
};

export const productsReducer = (state = getDefaultProducts(), action: any = {}) => {
    const reducer = actionTypes[action.type];

    return reducer ?
        reducer(state, action) :
        state;
};
