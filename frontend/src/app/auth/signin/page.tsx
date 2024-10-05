import React from "react";
import Link from "next/link";
import Image from "next/image";
import { Metadata } from "next";
import Signin from "@/components/Auth/Signin";

export const metadata: Metadata = {
  title: "SmartMES",
  description: "SmartMES",
};

const SignIn: React.FC = () => {
  return (
    <div className="flex justify-center items-center h-dvh">
      <div className="rounded-[10px] bg-white shadow-1 dark:bg-gray-dark dark:shadow-card xl:w-1/2">
        <div className="flex justify-center items-center">
          <div className="w-full">
            <div className="w-full p-4 sm:p-12.5 xl:p-15">
              <Link
                className="flex justify-center items-center mb-10 "
                href="/"
              >
                <Image
                  className="hidden dark:block"
                  src={"/images/logo.png"}
                  alt="Logo"
                  width={176}
                  height={32}
                />
                <Image
                  className="dark:hidden"
                  src={"/images/logo.png"}
                  alt="Logo"
                  width={176}
                  height={32}
                />
              </Link>
              <Signin />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignIn;
