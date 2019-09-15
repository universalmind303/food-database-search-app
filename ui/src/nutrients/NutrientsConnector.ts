import { ComponentType } from "react";
import { connect } from 'react-redux';
import { Nutrient } from "./model";

export type State = {
    nutrient: Nutrient,
};

const mapStateToProps = ({nutrient}: State, ownProps: object) => ({
    nutrient,
    ...ownProps
});

const mapDispatchToProps = {
};
export const connectNutrient = (Component: ComponentType<any>) => connect(mapStateToProps, mapDispatchToProps)(Component);
