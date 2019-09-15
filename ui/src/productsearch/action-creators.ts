import { actions } from "../actions";

export const setProductQuery = (query: string) => ({
  productNameQuery: query,
  type: actions.SET_PRODUCT_QUERY
});
