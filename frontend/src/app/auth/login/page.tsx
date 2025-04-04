import { Metadata } from "next";
import LoginPage from "./pages/LoginPage";

export async function generateMetadata(): Promise<Metadata> {
  return {
    title: 'Tierra Viva | Iniciar sesión'
  }
}

export default function Page() {
  return (
    <>
      <LoginPage />
    </>
  )
}

