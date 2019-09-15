import { Children, Component } from "react";
import { connectNutrientsProvider } from "./NutrientsProviderConnector";
import { Nutrient } from "./model";
import _ from 'lodash'


export type NutrientsProviderProps = {
    nutrientQuery: string,
    setNutrients: Function
};


export class NutrientsProviderBase extends Component<NutrientsProviderProps> {
    public componentDidMount = () => {
        this.setNutrients();
    }

    public componentDidUpdate = () => {
        this.setNutrients();
    } 

    public render = () => Children.only(this.props.children);

    public setNutrients = () => {
        const {setNutrients, nutrientQuery} = this.props;
        console.log("setNutrients", nutrientQuery)

        const setNutrientsDebounced = _.debounce(setNutrients as any, 100);

        setNutrientsDebounced(nutrientQuery)
    }
}

export const NutrientsProvider = connectNutrientsProvider(NutrientsProviderBase);
