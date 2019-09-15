import { Children, Component } from "react";
import { connectProductsProvider } from "./ProductsProviderConnector";
import { ProductsType } from "./model";
import _ from 'lodash'
export type ProductsProviderProps = {
    productNameQuery: string
    setProducts: Function,
    products: ProductsType
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

        const {setProducts, productNameQuery} = this.props;

        const setProductsDebounced = _.debounce(setProducts as any, 100);

        setProductsDebounced(productNameQuery)
    }
}

export const ProductsProvider = connectProductsProvider(ProductsProviderBase);
