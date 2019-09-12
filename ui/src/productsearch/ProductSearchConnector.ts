

import {ComponentType} from 'react';
import {ProductQueryType} from './type';
import {connect} from 'react-redux';
import { setProductQuery } from './action-creators';

export type State = {
    productNameQuery: Pick<ProductQueryType, 'productNameQuery'>
};

const mapStateToProps = ({productNameQuery}: State, ownProps: object) => ({
    productNameQuery: productNameQuery,
    ...ownProps
});

const mapDispatchToProps = {
    setProductQuery
};


export const connectProductSearch = (Component: ComponentType<any>) => connect(mapStateToProps, mapDispatchToProps)(Component);
