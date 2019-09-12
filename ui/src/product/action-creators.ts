import * as productRepositories from './repositories';
import {actions} from '../actions';
import { HTTP_STATUS_OK } from '../common/status';


export const setProducts = (query: string) =>
    async (dispatch: Function) => {
        dispatch({
            type: actions.START_FETCHING_PRODUCTS
        });

        const {status, products} = await productRepositories.getProducts(query);

        if (status === HTTP_STATUS_OK) {
            dispatch({
                products,
                type: actions.SET_PRODUCTS
            });
            dispatch({
                type: actions.CLEAR_PRODUCTS_ERROR
            });
        } else {
            dispatch({
                type: actions.RESET_PRODUCTS
            });
            dispatch({
                code: status,
                type: actions.NOTIFY_PRODUCTS_ERROR
            });
        }

        dispatch({
            type: actions.FINISHED_FETCHING_PRODUCTS
        });
    };
