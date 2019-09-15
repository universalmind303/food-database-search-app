import { actions } from "../actions";

export const setNutrientQuery = (query: string) => ({
  nutrientQuery: query,
  type: actions.SET_NUTRIENT_QUERY
});
