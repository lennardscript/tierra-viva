import { Metadata } from "next";
import RegisterPage from "./pages/RegisterPage";

export async function generateMetadata(): Promise<Metadata> {
  return {
    title: 'Tierra Viva | Registro'
  }
}

export default function Page() {
  return (
    <>
      <RegisterPage />
    </>
  )
}

