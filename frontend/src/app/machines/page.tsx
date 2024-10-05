"use client";
import Breadcrumb from "@/components/Breadcrumbs/Breadcrumb";
import TableOne from "@/components/Tables/TableOne";
import DefaultLayout from "@/components/Layouts/DefaultLaout";

const MachinesPage = () => {
  return (
    <DefaultLayout>
      <Breadcrumb pageName="Listagem de Máquinas" />
      <div className="flex flex-col gap-10">
        <TableOne />
      </div>
    </DefaultLayout>
  );
};

export default MachinesPage;
