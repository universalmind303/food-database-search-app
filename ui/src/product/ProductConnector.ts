import { ComponentType } from "react";
import { connect } from 'react-redux';
import { ProductsType } from "./model";
import { setProductQuery } from '../productsearch/action-creators';

export type State = {
    products: ProductsType,
};

const mapStateToProps = ({products}: State, ownProps: object) => ({
    products,
    ...ownProps
});

const mapDispatchToProps = {
    setProductQuery,
};
export const connectProduct = (Component: ComponentType<any>) => connect(mapStateToProps, mapDispatchToProps)(Component);
