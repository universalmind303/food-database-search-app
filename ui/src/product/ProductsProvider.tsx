import { Children, Component } from "react";
import { connectProductsProvider } from "./ProductsProviderConnector";

export type ProductsProviderProps = {
    productNameQuery: string
    setProducts: Function,
};


export class ProductsProviderBase extends Component<ProductsProviderProps> {
    public componentDidMount = () => {
        this.setProducts();
    }

    public componentDidUpdate = () => {
        this.setProducts();
    }

    public render = () => Children.only(this.props.children);

    public setProducts = () => {
        this.props.setProducts(this.props.productNameQuery);
    }
}

export const ProductsProvider = connectProductsProvider(ProductsProviderBase);
