import {applyMiddleware, createStore} from 'redux';
import {State} from './state';
import {composeWithDevTools} from 'redux-devtools-extension';
import {createCheckedReducer } from 'redux-tcomb';
import thunk from 'redux-thunk';

export const create = (reducers: any) => {
    const checkedReducers = createCheckedReducer(reducers, State);

    const middlewareStoreCreator = composeWithDevTools(
        applyMiddleware(thunk)
    )(createStore);

    return middlewareStoreCreator(checkedReducers);
};
