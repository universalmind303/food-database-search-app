import React from 'react';
import './App.css';
import { ProductsProvider } from './product/ProductsProvider';
import Product from './product/Product';

const App: React.FC = () => {
  return (
    <div className="App">
      <ProductsProvider>
        <Product />
      </ProductsProvider>
    </div>
  );
}

export default App;
