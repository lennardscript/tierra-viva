import Products from "../features/Products";

export default function Hero() {
  return (
    <>
      <section>
        <div className="mx-auto max-w-screen-xl px-4 py-8 sm:px-6 lg:px-8">
          <div className="grid grid-cols-1 gap-4 md:grid-cols-2 md:items-center md:gap-8">
            <div>
              <div className="max-w-lg md:max-w-none">
                <h2 className="text-2xl font-semibold text-gray-900 sm:text-3xl">
                  Tierra Viva: Cultivando un futuro sostenible con productos ecológicos para tu hogar y jardín
                </h2>
                <p className="mt-4 text-gray-700">
                  Sostenibilidad y cuidado ambiental
                </p>
              </div>
            </div>

            <div>
              <img
                src="https://images.unsplash.com/photo-1611843467160-25afb8df1074?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                className="rounded"
                alt="image_unsplash"
              />
            </div>
          </div>
        </div>
      </section>
      <Products />
    </>
  )
}

