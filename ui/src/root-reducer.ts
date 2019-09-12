import { combineReducers } from "redux";
import { productQueryReducer } from "./productsearch/reducers";
import { productsReducer } from "./product/reducers";

export const getReducer = () =>
    combineReducers({
        products: productsReducer,
        productQuery: productQueryReducer,

    });