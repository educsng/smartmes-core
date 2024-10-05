"use client";
import Breadcrumb from "@/components/Breadcrumbs/Breadcrumb";
import TableTwo from "@/components/Tables/TableTwo";
import DefaultLayout from "@/components/Layouts/DefaultLaout";

const MachinesPage = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Ordens de Produção" />
      <div className="flex flex-col gap-10">
        <TableTwo />
      </div>
    </DefaultLayout>
  );
};

export default MachinesPage;
