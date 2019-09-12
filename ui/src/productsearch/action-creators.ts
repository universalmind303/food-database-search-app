import { actions } from "../actions";
import { HTTP_STATUS_OK } from "../common/status";

export const setProductQuery = (query: string) => ({
  query,
  type: actions.SET_PRODUCT_QUERY
});
