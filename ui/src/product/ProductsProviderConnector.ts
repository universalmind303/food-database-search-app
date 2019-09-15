import { ComponentType } from "react";
import { connect } from 'react-redux';
import { setProducts } from "./action-creators";

export type State = {
    productQuery: {
        productNameQuery: string
    }
};

const mapStateToProps = ({productQuery}: State, ownProps: object) => ({
    productNameQuery: productQuery.productNameQuery,
    ...ownProps
});

const mapDispatchToProps = {
    setProducts
};

export const connectProductsProvider = (Component: ComponentType<any>) => connect(mapStateToProps, mapDispatchToProps)(Component);
