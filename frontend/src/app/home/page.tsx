import { Metadata } from "next";
import Layout from "./layout/Layout";
import HomePage from "./page/HomePage";

export async function generateMetadata(): Promise<Metadata> {
  return {
    title: 'Tierra Viva | Home'
  }
}

export default function Page() {
  return (
    <>
      <Layout>
        <HomePage />
      </Layout>
    </>
  )
}

