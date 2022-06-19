import React from 'react'
import { useSelector } from 'react-redux'

const Checkout = () => {

  const cart = useSelector(state => state.cart);
  let totalPrice = 0;
  for (const item of cart) {
      console.log(item)
      totalPrice += item.quantity * item.wine.buyPrice;
  }

  return (
    <div className="mt-16 bg-primary/20 px-16 py-8 rounded-xl flex flex-col">
        <p className="text-3xl font-bold">Checkout</p>
        <p className="text-xl font-medium mt-4">Total Price: <span className="ml-3 font-normal">{totalPrice}€</span></p>
        <p className="text-xl font-medium mt-1">Payment: <span className="ml-3 font-normal">Card</span></p>
        <p className="text-xl font-medium mt-1">Delivery: <span className="ml-3 font-normal">Your Home</span></p>
        <button className="bg-primary-shade-6 px-4 py-2 text-white rounded-xl text-xl self-end">Buy!</button>
    </div>
  )
}

export default Checkout