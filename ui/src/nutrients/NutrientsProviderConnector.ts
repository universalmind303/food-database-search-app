import { ComponentType } from "react";
import { connect } from 'react-redux';
import { setNutrients } from "./action-creators";
import { Nutrient } from "./model";

export type State = {
    nutrientQuery: {
        nutrientQuery: Nutrient
    }
};

const mapStateToProps = ({nutrientQuery}: State, ownProps: object) => ({
    nutrientQuery: nutrientQuery.nutrientQuery,
    ...ownProps
});

const mapDispatchToProps = {
    setNutrients
};

export const connectNutrientsProvider = (Component: ComponentType<any>) => connect(mapStateToProps, mapDispatchToProps)(Component);
