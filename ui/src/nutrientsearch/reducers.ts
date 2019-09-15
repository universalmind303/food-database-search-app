
import { NutrientQueryType, getDefaultNutrientQuery } from "./type";
import { actions } from "../actions";

const setNutrientSearchQuery = (
  state: NutrientQueryType,
  action: any
): NutrientQueryType => ({
  ...state,
  nutrientNameQuery: action.nutrientNameQuery
});
// const resetNutrientSearchQuery = () => getDefaultNutrientQuery();

const actionTypes = {
  [actions.SET_PRODUCT_QUERY]: setNutrientSearchQuery
};

export const nutrientQueryReducer = (
  state: any = getDefaultNutrientQuery(),
  action: any = {}
) => {
  const reducer = actionTypes[action.type];
  return reducer ? reducer(state, action) : state;
};
