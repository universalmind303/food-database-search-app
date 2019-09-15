import { getDefaultNutrient, Nutrient } from "./model";
import {actions} from '../actions';

const resetNutrients = (state: any) => Nutrient.update(state, {
    $set: getDefaultNutrient()
});

const setNutrients = (state: any, action: any) => Nutrient.update(state, {
    $set: action.nutrient
});

const actionTypes = {
    [actions.RESET_NUTRIENTS]: resetNutrients,
    [actions.SET_NUTRIENTS]: setNutrients
};

export const nutrientReducer = (state = getDefaultNutrient(), action: any = {}) => {
    const reducer = actionTypes[action.type];

    return reducer ?
        reducer(state, action) :
        state;
};


