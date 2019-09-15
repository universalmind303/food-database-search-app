import { ProductQueryType, getDefaultProductQuery } from "./type";
import { actions } from "../actions";

const setProductSearchQuery = (
  state: ProductQueryType,
  action: any
): ProductQueryType => ({
  ...state,
  productNameQuery: action.productNameQuery
});
// const resetProductSearchQuery = () => getDefaultProductQuery();

const actionTypes = {
  [actions.SET_PRODUCT_QUERY]: setProductSearchQuery
};

export const productQueryReducer = (
  state: any = getDefaultProductQuery(),
  action: any = {}
) => {
  const reducer = actionTypes[action.type];
  return reducer ? reducer(state, action) : state;
};
