import { combineReducers } from "redux";
import { productQueryReducer } from "./productsearch/reducers";
import { productsReducer } from "./product/reducers";
import { nutrientReducer } from "./nutrients/reducers";
import { nutrientQueryReducer } from "./nutrientsearch/reducers";

export const getReducer = () =>
    combineReducers({
        products: productsReducer,
        productQuery: productQueryReducer,
        nutrient: nutrientReducer,
        nutrientQuery: nutrientQueryReducer

    });