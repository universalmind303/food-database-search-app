import {actions} from '../actions';
import { HTTP_STATUS_OK } from '../common/status';
import { getNutrient } from './repositories';


export const setNutrients = (query: string) =>
    async (dispatch: Function) => {
        dispatch({
            type: actions.START_FETCHING_NUTRIENTS
        });

        const {status, nutrient} = await getNutrient(query);

        if (status === HTTP_STATUS_OK) {
            dispatch({
                nutrient,
                type: actions.SET_NUTRIENTS
            });
            dispatch({
                type: actions.CLEAR_NUTRIENTS_ERROR
            });
        } else {
            dispatch({
                type: actions.RESET_NUTRIENTS
            });
            dispatch({
                code: status,
                type: actions.NOTIFY_NUTRIENTS_ERROR
            });
        }

        dispatch({
            type: actions.FINISHED_FETCHING_NUTRIENTS
        });
    };


export const setNutrientQuery = (query: string) => ({
    nutrientQuery: query,
    type: actions.SET_NUTRIENT_QUERY
  });
  