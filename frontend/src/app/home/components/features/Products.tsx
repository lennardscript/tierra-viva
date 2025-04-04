export default function Products() {
  return (
    <>
      <section>
        <div className="mx-auto max-w-screen-xl px-4 py-8 sm:px-6 sm:py-12 lg:px-8">
          <header className="text-center">
            <h2 className="text-xl font-bold text-gray-900 sm:text-3xl">Productos destacados</h2>

            <p className="mx-auto mt-4 max-w-md text-gray-500">
              🌳 Puede visualizar nuestros productos más destacados 🌳
            </p>
          </header>

          <ul className="mt-8 grid gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 ">
            <li className="flex justify-center">
              <a href="#" className="group block overflow-hidden w-full max-w-[300px]">
                <img
                  src="https://plus.unsplash.com/premium_photo-1676475964992-6404b8db0b53?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                  alt=""
                  className="h-[350px] w-full object-cover transition duration-500 group-hover:scale-105 sm:h-[450px]"
                />

                <div className="relative bg-white pt-3">
                  <h3 className="text-xs text-gray-700 group-hover:underline group-hover:underline-offset-4">
                    Ramo de flores
                  </h3>

                  <p className="mt-2">
                    <span className="tracking-wider text-gray-900"> $5.600 CLP </span>
                  </p>
                </div>
              </a>
            </li>

            <li className="flex justify-center">
              <a href="#" className="group block overflow-hidden w-full max-w-[300px]">
                <img
                  src="https://images.unsplash.com/photo-1541275055241-329bbdf9a191?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                  alt=""
                  className="h-[350px] w-full object-cover transition duration-500 group-hover:scale-105 sm:h-[450px]"
                />

                <div className="relative bg-white pt-3">
                  <h3 className="text-xs text-gray-700 group-hover:underline group-hover:underline-offset-4">
                    Flor de pétalos de púrpura
                  </h3>

                  <p className="mt-2">
                    <span className="tracking-wider text-gray-900"> $4.300 CLP </span>
                  </p>
                </div>
              </a>
            </li>

            <li className="flex justify-center">
              <a href="#" className="group block overflow-hidden w-full max-w-[300px]">
                <img
                  src="https://images.unsplash.com/photo-1519378058457-4c29a0a2efac?q=80&w=2008&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                  alt=""
                  className="h-[350px] w-full object-cover transition duration-500 group-hover:scale-105 sm:h-[450px]"
                />

                <div className="relative bg-white pt-3">
                  <h3 className="text-xs text-gray-700 group-hover:underline group-hover:underline-offset-4">
                    Flores de pétalos rojos
                  </h3>

                  <p className="mt-2">
                    <span className="tracking-wider text-gray-900"> $3.800 CLP </span>
                  </p>
                </div>
              </a>
            </li>

            <li className="flex justify-center">
              <a href="#" className="group block overflow-hidden w-full max-w-[300px]">
                <img
                  src="https://images.unsplash.com/photo-1523301551780-cd17359a95d0?q=80&w=1973&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                  alt=""
                  className="h-[350px] w-full object-cover transition duration-500 group-hover:scale-105 sm:h-[450px]"
                />

                <div className="relative bg-white pt-3">
                  <h3 className="text-xs text-gray-700 group-hover:underline group-hover:underline-offset-4">
                    Kit de herramientas básicas de jardinería
                  </h3>

                  <p className="mt-2">
                    <span className="tracking-wider text-gray-900"> $9.990 CLP </span>
                  </p>
                </div>
              </a>
            </li>
          </ul>
        </div>
      </section>
    </>
  )
}

